package com.elif.studioapp.data.repository;

import com.elif.studioapp.data.entity.Director;
import org.csystem.util.data.repository.ICrudRepository;

public interface IDirectorRepository extends ICrudRepository<Director, Long> {
    Iterable<Director> findDirectorsByFirstName(String firstName);
    Iterable<Director> findDirectorsByFamilyName(String familyName);
}
