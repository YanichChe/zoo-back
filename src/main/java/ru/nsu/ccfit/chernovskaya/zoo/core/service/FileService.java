package ru.nsu.ccfit.chernovskaya.zoo.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.File;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.repository.FileRepository;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileService {
    @Value("${file.upload-dir}")
    private String uploadDirectory;

    private final FileRepository fileRepository;
    public Resource getFileById(int id) throws FileNotFoundException, MalformedURLException {
        Optional<File> file = fileRepository.findById(id);
        if (file.isEmpty()) {
            throw new FileNotFoundException();
        }
        Path filePath = Paths.get(uploadDirectory + file.get().getPath());
        return new UrlResource(filePath.toUri());
    }
}
