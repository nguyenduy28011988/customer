package com.learning.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "Firstname is required")
        String firstname,
        @NotNull(message = "Customername is required")
        String lastname,
        @NotNull(message = "Email is required")
        @Email(message = "Email is not valid")
        String email,
        Address address
) {


}
