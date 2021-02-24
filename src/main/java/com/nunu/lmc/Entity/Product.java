package com.nunu.lmc.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY,
            generator="uuid"
    )
    @GenericGenerator(
            name = "uuid",
            strategy = "uuid"
    )
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image_file")
    private String imageFile;

    @Column(name = "material")
    private String material;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Product() {
    }

    public Product(String id, String name, String imageFile, String material, String description, Category category) {
        this.id = id;
        this.name = name;
        this.imageFile = imageFile;
        this.material = material;
        this.description = description;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", imageFile='" + imageFile + '\'' +
                ", material='" + material + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
