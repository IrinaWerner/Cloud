package ru.mycloud.cloud.repository.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mycloud.cloud.entity.file.TypeOfFileAccess;

@Repository
public interface TypeOfFileAccessRepository extends JpaRepository<TypeOfFileAccess, Long> {
}
