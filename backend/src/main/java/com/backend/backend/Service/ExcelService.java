package com.backend.backend.Service;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backend.backend.Helper.ExcelHelper;
import com.backend.backend.Model.Tutorial;
import com.backend.backend.Repository.TutorialRepository;

@Service
public class ExcelService {
  @Autowired
  TutorialRepository repository;

  public void save(MultipartFile file) {
    try {
      List<Tutorial> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
      repository.saveAll(tutorials);
    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }

  public List<Tutorial> getAllTutorials() {
    return repository.findAll();
  }
}

