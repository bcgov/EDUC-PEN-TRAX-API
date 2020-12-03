package ca.bc.gov.educ.api.pen.trax.mapper.v1;

import ca.bc.gov.educ.api.pen.trax.model.*;
import ca.bc.gov.educ.api.pen.trax.struct.v1.*;
import ca.bc.gov.educ.api.pen.trax.mapper.LocalDateTimeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {LocalDateTimeMapper.class})
@SuppressWarnings("squid:S1214")
public interface TraxMapper {

    TraxMapper mapper = Mappers.getMapper(TraxMapper.class);

    StudentEntity toModel(Student student);

    Student toStructure(StudentEntity studentEntity);

    StudXcrseEntity toModel(StudXcrse studXcrse);

    @Mapping(target = "studNo", source="studXcrseEntity.studXcrseId.studNo")
    @Mapping(target = "crseCode", source="studXcrseEntity.studXcrseId.crseCode")
    @Mapping(target = "crseLevel", source="studXcrseEntity.studXcrseId.crseLevel")
    @Mapping(target = "crseSession", source="studXcrseEntity.studXcrseId.crseSession")
    StudXcrse toStructure(StudXcrseEntity studXcrseEntity);

    ProvExamEntity toModel(ProvExam provExam);

    @Mapping(target = "studNo", source="provExamEntity.provExamId.studNo")
    @Mapping(target = "crseCode", source="provExamEntity.provExamId.crseCode")
    @Mapping(target = "crseLevel", source="provExamEntity.provExamId.crseLevel")
    @Mapping(target = "crseSession", source="provExamEntity.provExamId.crseSession")
    ProvExam toStructure(ProvExamEntity provExamEntity);

    StudGradAssmtEntity toModel(StudGradAssmt studGradAssmt);

    @Mapping(target = "studNo", source="studGradAssmtEntity.studGradAssmtId.studNo")
    @Mapping(target = "assmtCode", source="studGradAssmtEntity.studGradAssmtId.assmtCode")
    @Mapping(target = "assmtSession", source="studGradAssmtEntity.studGradAssmtId.assmtSession")
    StudGradAssmt toStructure(StudGradAssmtEntity studGradAssmtEntity);

    TabSchoolEntity toModel(TabSchool tabSchool);

    TabSchool toStructure(TabSchoolEntity tabSchoolEntity);
}
