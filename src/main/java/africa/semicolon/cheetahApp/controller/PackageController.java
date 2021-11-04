package africa.semicolon.cheetahApp.controller;

import africa.semicolon.cheetahApp.data.dtos.request.AddPackageRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetahApp.data.models.Package;
import africa.semicolon.cheetahApp.service.PackageService;
import africa.semicolon.cheetahApp.service.PackageServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageController {

    private final PackageService packageService = new PackageServiceImpl();

    @PostMapping("/api/addpackage")
    public AddPackageResponse addPackage(@RequestBody AddPackageRequest addPackageRequest){

        return packageService.addPackage(addPackageRequest);
    }
    @GetMapping("/api/package{id}")
   public Package findPackageBy(@PathVariable("id") Integer id){
        return packageService.findMyPackageWith(id);
   }
}
