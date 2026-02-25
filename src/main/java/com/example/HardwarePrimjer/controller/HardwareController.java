package com.example.HardwarePrimjer.controller;

import com.example.HardwarePrimjer.dto.HardwareDTO;
import com.example.HardwarePrimjer.service.HardwareService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardware")
@AllArgsConstructor
public class HardwareController {
    private HardwareService hardwareService;

    @GetMapping
    public List<HardwareDTO> getAllHardware() {
        return hardwareService.getAllHardware().stream().toList();
    }

    @GetMapping("/{hardwareName}")
    public List<HardwareDTO> filterHardwareByName(@PathVariable String hardwareName) {
        return hardwareService.getHardwareByName(hardwareName).stream().toList();
    }

//    @PostMapping("/new")
//    public Integer saveNewArticle(@Valid @RequestBody HardwareDTO hardwareDTO) {
//        Integer generatedId = hardwareService.saveNewHardwarePost(hardwareDTO);
//        return generatedId;
//    }

    @PostMapping("/new")
    public ResponseEntity<?> saveNewHardwarePost(@Valid @RequestBody HardwareDTO hardwareDTO) {
        hardwareService.saveNewHardwarePost(hardwareDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/hardware/{hardwareId}")
    public ResponseEntity<HardwareDTO> updateHardware(@Valid @RequestBody HardwareDTO hadwareDTO, @PathVariable Integer hardwareId) {
        if (hardwareService.hardwareByIdExists(hardwareId)) {
            hardwareService.updateHardware(hadwareDTO, hardwareId);
            return ResponseEntity.ok(hadwareDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{hardwareId}")
    public ResponseEntity<?> deleteHardware(@PathVariable Integer hardwareId) {
        if (hardwareService.hardwareByIdExists(hardwareId)) {
            boolean result = hardwareService.deleteHardwareById(hardwareId);
            if (result) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
