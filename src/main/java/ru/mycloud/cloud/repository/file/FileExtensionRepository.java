package ru.mycloud.cloud.repository.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mycloud.cloud.entity.file.FileExtension;

@Repository
public interface FileExtensionRepository extends JpaRepository<FileExtension, Long> {
}
