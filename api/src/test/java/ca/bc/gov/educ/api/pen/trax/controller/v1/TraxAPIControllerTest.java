package ca.bc.gov.educ.api.pen.trax.controller.v1;

import ca.bc.gov.educ.api.pen.trax.TraxApiResourceApplication;
import ca.bc.gov.educ.api.pen.trax.exception.RestExceptionHandler;
import ca.bc.gov.educ.api.pen.trax.model.*;
import ca.bc.gov.educ.api.pen.trax.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Trax api controller test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TraxApiResourceApplication.class})
@AutoConfigureMockMvc
@Slf4j
@SuppressWarnings({"java:S112", "java:S100", "java:S1192","java:S2699"})
public class TraxAPIControllerTest {

  /**
   * The Controller.
   */
  @Autowired
  TraxAPIController controller;
  /**
   * The Mock mvc.
   */
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  StudXcrseRepository studXcrseRepository;

  @Autowired
  ProvExamRepository provExamRepository;

  @Autowired
  StudGradAssmtRepository studGradAssmtRepository;

  @Autowired
  TabSchoolRepository tabSchoolRepository;

  private String studentNo = "123456789";
  private String mincode = "00212345";

  private StudentEntity studentEntity;

  private List<StudXcrseEntity> studXcrseEntities;

  private List<ProvExamEntity> provExamEntities;

  private List<StudGradAssmtEntity> studGradAssmtEntities;

  private TabSchoolEntity tabSchoolEntity;

  /**
   * Sets up.
   *
   * @throws IOException the io exception
   */
  @Before
  public void setUp() throws IOException {
    MockitoAnnotations.openMocks(this);
    studentEntity = studentRepository.save(createStudent(studentNo));
    studXcrseEntities = studXcrseRepository.saveAll(List.of(createStudXcrse(studentNo, "10"), createStudXcrse(studentNo, "11")));
    provExamEntities = provExamRepository.saveAll(List.of(createProvExam(studentNo, "12"), createProvExam(studentNo, "13")));
    studGradAssmtEntities = studGradAssmtRepository.saveAll(List.of(createStudGradAssmt(studentNo, "NME"), createStudGradAssmt(studentNo, "STE")));
    tabSchoolEntity = tabSchoolRepository.save(createTabSchool(mincode));
  }

  /**;
   * need to delete the records to make it working in unit tests assertion, else the records will keep growing and assertions will fail.
   */
  @After
  public void after() {
    studentRepository.deleteAll();
    studXcrseRepository.deleteAll();
    provExamRepository.deleteAll();
    studGradAssmtRepository.deleteAll();
    tabSchoolRepository.deleteAll();
  }

  @Test
  public void testGetStudent_GivenValidStudentNo_ShouldReturnStatusOK() throws Exception {
    this.mockMvc.perform(get("/api/v1/students")
            .with(jwt().jwt((jwt) -> jwt.claim("scope", "READ_PEN_TRAX")))
            .param("studNo", studentNo)).andDo(print()).andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.studGiven").value(studentEntity.getStudGiven()));
  }

  @Test
  public void testGetStudent_GivenNoExistStudentNo_ShouldReturnStatusNotFound() throws Exception {
    this.mockMvc.perform(get("/api/v1/students")
            .with(jwt().jwt((jwt) -> jwt.claim("scope", "READ_PEN_TRAX")))
            .param("studNo", "12345670")).andDo(print()).andExpect(status().isNotFound());
  }

  @Test
  public void testFindStudXcrse_GivenValidStudentNo_ShouldReturnStatusOK() throws Exception {
    Map<String, String> sortMap = new HashMap<>();
    sortMap.put("studXcrseId.crseLevel", "DESC");
    String sort = new ObjectMapper().writeValueAsString(sortMap);

    MvcResult result = mockMvc
      .perform(get("/api/v1/stud-xcrses/paginated")
              .with(jwt().jwt((jwt) -> jwt.claim("scope", "READ_PEN_TRAX")))
              .param("studNo", studentNo)
        .param("sort", sort)
        .contentType(APPLICATION_JSON))
      .andReturn();

    this.mockMvc.perform(asyncDispatch(result)).andDo(print()).andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.content", hasSize(2)));
  }

  @Test
  public void testFindStudXcrse_GivenNoExistStudentNo_ShouldReturnStatusOK() throws Exception {
    MvcResult result = mockMvc
      .perform(get("/api/v1/stud-xcrses/paginated")
              .with(jwt().jwt((jwt) -> jwt.claim("scope", "READ_PEN_TRAX")))
              .param("studNo", "12345670")
        .contentType(APPLICATION_JSON))
      .andReturn();

    this.mockMvc.perform(asyncDispatch(result)).andDo(print()).andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.content", hasSize(0)));
  }

  @Test
  public void testFindProvExam_GivenValidStudentNo_ShouldReturnStatusOK() throws Exception {
    Map<String, String> sortMap = new HashMap<>();
    sortMap.put("provExamId.crseLevel", "DESC");
    String sort = new ObjectMapper().writeValueAsString(sortMap);

    MvcResult result = mockMvc
      .perform(get("/api/v1/prov-exams/paginated")
              .with(jwt().jwt((jwt) -> jwt.claim("scope", "READ_PEN_TRAX")))
              .param("studNo", studentNo)
        .param("sort", sort)
        .contentType(APPLICATION_JSON))
      .andReturn();

    this.mockMvc.perform(asyncDispatch(result)).andDo(print()).andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.content", hasSize(2)));
  }

  @Test
  public void testFindProvExam_GivenNoExistStudentNo_ShouldReturnStatusOK() throws Exception {
    MvcResult result = mockMvc
      .perform(get("/api/v1/prov-exams/paginated")
              .with(jwt().jwt((jwt) -> jwt.claim("scope", "READ_PEN_TRAX")))
              .param("studNo", "12345670")
        .contentType(APPLICATION_JSON))
      .andReturn();

    this.mockMvc.perform(asyncDispatch(result)).andDo(print()).andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.content", hasSize(0)));
  }

  @Test
  public void testFindStudGradAssmt_GivenValidStudentNo_ShouldReturnStatusOK() throws Exception {
    Map<String, String> sortMap = new HashMap<>();
    sortMap.put("studGradAssmtId.assmtCode", "DESC");
    String sort = new ObjectMapper().writeValueAsString(sortMap);

    MvcResult result = mockMvc
      .perform(get("/api/v1/stud-grad-assmts/paginated")
              .with(jwt().jwt((jwt) -> jwt.claim("scope", "READ_PEN_TRAX")))
              .param("studNo", studentNo)
        .param("sort", sort)
        .contentType(APPLICATION_JSON))
      .andReturn();

    this.mockMvc.perform(asyncDispatch(result)).andDo(print()).andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.content", hasSize(2)));
  }

  @Test
  public void testFindStudGradAssmt_GivenNoExistStudentNo_ShouldReturnStatusOK() throws Exception {
    MvcResult result = mockMvc
      .perform(get("/api/v1/stud-grad-assmts/paginated")
              .with(jwt().jwt((jwt) -> jwt.claim("scope", "READ_PEN_TRAX")))
              .param("studNo", "12345670")
        .contentType(APPLICATION_JSON))
      .andReturn();

    this.mockMvc.perform(asyncDispatch(result)).andDo(print()).andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.content", hasSize(0)));
  }

  @Test
  public void testGetTabSchool_GivenValidMincode_ShouldReturnStatusOK() throws Exception {
    this.mockMvc.perform(get("/api/v1/tab-schools")
            .with(jwt().jwt((jwt) -> jwt.claim("scope", "READ_PEN_TRAX")))
            .param("mincode", mincode)).andDo(print()).andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.schlName").value(tabSchoolEntity.getSchlName()));
  }

  @Test
  public void testGetTabSchool_GivenNoExistMincode_ShouldReturnStatusNotFound() throws Exception {
    this.mockMvc.perform(get("/api/v1/tab-schools")
            .with(jwt().jwt((jwt) -> jwt.claim("scope", "READ_PEN_TRAX")))
            .param("mincode", "00123456")).andDo(print()).andExpect(status().isNotFound());
  }

  private StudentEntity createStudent(String studentNo) {
    var school = StudentEntity.builder()
      .studNo(studentNo)
      .studGiven("Ben")
      .build();
    return school;
  }

  private StudXcrseEntity createStudXcrse(String studentNo, String crseCode) {
    var studXcrseId = StudXcrseId.builder()
      .studNo(studentNo)
      .crseCode("BE")
      .crseLevel(crseCode)
      .crseSession("199306")
      .build();
    var studXcrse = StudXcrseEntity.builder()
      .studXcrseId(studXcrseId)
      .numCredits(4L)
      .build();
    return studXcrse;
  }

  private ProvExamEntity createProvExam(String studentNo, String crseCode) {
    var provExamId = ProvExamId.builder()
      .studNo(studentNo)
      .crseCode("EN")
      .crseLevel(crseCode)
      .crseSession("199306")
      .build();
    var provExam = ProvExamEntity.builder()
      .provExamId(provExamId)
      .finalLg("B")
      .build();
    return provExam;
  }

  private StudGradAssmtEntity createStudGradAssmt(String studentNo, String assmtCode) {
    var studGradAssmtId = StudGradAssmtId.builder()
      .studNo(studentNo)
      .assmtCode(assmtCode)
      .assmtSession("199306")
      .build();
    var studGradAssmt = StudGradAssmtEntity.builder()
      .studGradAssmtId(studGradAssmtId)
      .mincodeHome("01234567")
      .build();
    return studGradAssmt;
  }

  private TabSchoolEntity createTabSchool(String mincode) {
    var school = TabSchoolEntity.builder()
      .mincode(mincode)
      .schlName("Victoria High School")
      .build();
    return school;
  }
}
