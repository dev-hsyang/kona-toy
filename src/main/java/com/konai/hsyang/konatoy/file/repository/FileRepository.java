package com.konai.hsyang.konatoy.file.repository;

import com.konai.hsyang.konatoy.file.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {


}
