package com.wsiiz.repairshop.enterprise.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/branches")
    //@RestController
    //@RequestMapping("api/security/user-accounts")
    public class BranchController {

        private final BranchService branchService;

        public BranchController(BranchService branchService) {
            this.branchService = branchService;
        }

        @GetMapping
        public ResponseEntity<List<BranchDTO>> getAllBranches(@RequestParam(required = false) String city,
                                                              @RequestParam(required = false) Long parentId) {
            List<BranchDTO> branches = branchService.getAllBranches(city, parentId);
            return ResponseEntity.ok(branches);
        }

        @GetMapping("/{id}")
        public ResponseEntity<BranchDTO> getBranchById(@PathVariable Long id) {
            BranchDTO branch = branchService.getBranchById(id);
            if (branch == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(branch);
        }

        @PostMapping
        public ResponseEntity<BranchDTO> addBranch(@RequestBody BranchDTO branchDTO) {
            BranchDTO createdBranch = branchService.addBranch(branchDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBranch);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
            branchService.deleteBranch(id);
            return ResponseEntity.noContent().build();
        }
    }


