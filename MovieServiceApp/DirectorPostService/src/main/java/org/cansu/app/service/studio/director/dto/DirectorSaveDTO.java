package org.cansu.app.service.studio.director.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

public class DirectorSaveDTO {
    public long directorId;
    public String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String middleName;
    public String familyName;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate birthDate;
}
