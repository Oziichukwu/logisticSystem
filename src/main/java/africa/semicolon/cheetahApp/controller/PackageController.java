package africa.semicolon.cheetahApp.controller;

import africa.semicolon.cheetahApp.data.dtos.request.AddPackageRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetahApp.data.exceptions.SenderDoesNotExistException;
import africa.semicolon.cheetahApp.data.models.Package;
import africa.semicolon.cheetahApp.service.PackageService;
import africa.semicolon.cheetahApp.service.PackageServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PackageController {

    private final PackageService packageService = new PackageServiceImpl();

    @PostMapping("/api/addpackage")
    public ResponseEntity<?> addPackage(@RequestBody AddPackageRequest addPackageRequest){
        try {
            AddPackageResponse response = packageService.addPackage(addPackageRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (SenderDoesNotExistException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/api/package/{id}")
   public Package findPackageBy(@PathVariable("id") Integer packageId){
        return packageService.findMyPackageWith(packageId);
   }
}
