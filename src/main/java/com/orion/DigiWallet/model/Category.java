package com.orion.DigiWallet.model;

import jakarta.persistence.*;

//TODO: 3.2
// READ ONLY
// Define this class as a JPA entity mapped to "category" table
// ADD @table annotation to specify the table name as "category"
@Entity
@Table(name = "category")
public class Category {

    //TODO: 3.2.1
    // Define id as primary key with auto-generation strategy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO: 3.2.2
    // Define name field
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    //TODO: 3.2.3
    // Define "type" field to indicate if category is INCOME or EXPENSE
    @Column(name = "type", nullable = false, length = 20)
    private String type;

    //TODO: 3.2.4
    // Generate getters and setters for all fields
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}