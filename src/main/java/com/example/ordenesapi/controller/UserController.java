package com.example.ordenesapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.example.ordenesapi.repository.UserRepository;
import com.example.ordenesapi.mapper.UserMapper;
import com.example.ordenesapi.dto.request.UserRequest;
import com.example.ordenesapi.dto.response.UserResponse;
import com.example.ordenesapi.entity.User;

import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Excel
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;
    private final UserMapper mapper;

    @PostMapping
    public UserResponse create(@RequestBody UserRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    // ENDPOINT PARA EXPORTAR A EXCEL
    @GetMapping("/excel")
    public ResponseEntity<byte[]> exportUsersToExcel() throws IOException {

        List<User> users = repository.findAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Users");

        // Encabezados
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Nombre");
        header.createCell(2).setCellValue("Email");
        header.createCell(3).setCellValue("Telefono");

        // Datos
        int rowNum = 1;
        for (User user : users) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getName());
            row.createCell(2).setCellValue(user.getEmail());
            row.createCell(3).setCellValue(user.getPhone());
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=users.xlsx")
                .body(out.toByteArray());
    }
}