The code will run on port 5000, the follow commit for Git will be B1
Implemented Features (B1):
- Bootstrap styling applied with proper navigation header and footer
- Fixed route mappings: /products/create and /products/edit/{id} routes working correctly
- Local image directory creation and management implemented (static/images)
- Basic categories initialized via CategoryService (Stationery, Office Supplies, Writing Instruments, Paper Products, Art & Craft)
- Product creation fully functional with validation
- Delete functionality added for products
- Header and footer with black/dark theme styling applied via Bootstrap

Technologies Applied:
- Spring Validation: @Valid, @NotBlank, @NotNull, @Min, @Max with custom error messages
- Spring Web (MVC): @Controller, @RequestMapping, @GetMapping, @PostMapping, @PathVariable
- Thymeleaf: Template engine for all views with proper layout inheritance
- Lombok: @Getter, @Setter, @NoArgsConstructor, @AllArgsConstructor for POJOs