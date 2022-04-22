package com.yet.buchi.models.ApiModels;
import com.fasterxml.jackson.annotation.*;
import com.yet.buchi.models.*;
import com.yet.buchi.models.Age;


public class Animal {
    private long id;
    private OrganizationID organizationID;
    private String url;
    private Species type;
    private Species species;
    private Breeds breeds;
    private Colors colors;
    private Age age;
    private Gender gender;
    private Size size;
    private Size coat;
    private Attributes attributes;
    private Environment environment;
    private String[] tags;
    private String name;
    private String description;
    private String organizationAnimalID;
    private Photo[] photos;
    private Photo primaryPhotoCropped;
    private Object[] videos;
    private Status status;
    private EdAt statusChangedAt;
    private EdAt publishedAt;
    private Object distance;
    private Contact contact;
    private AnimalLinks links;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("organization_id")
    public OrganizationID getOrganizationID() { return organizationID; }
    @JsonProperty("organization_id")
    public void setOrganizationID(OrganizationID value) { this.organizationID = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("type")
    public Species getType() { return type; }
    @JsonProperty("type")
    public void setType(Species value) { this.type = value; }

    @JsonProperty("species")
    public Species getSpecies() { return species; }
    @JsonProperty("species")
    public void setSpecies(Species value) { this.species = value; }

    @JsonProperty("breeds")
    public Breeds getBreeds() { return breeds; }
    @JsonProperty("breeds")
    public void setBreeds(Breeds value) { this.breeds = value; }

    @JsonProperty("colors")
    public Colors getColors() { return colors; }
    @JsonProperty("colors")
    public void setColors(Colors value) { this.colors = value; }

    @JsonProperty("age")
    public Age getAge() { return age; }
    @JsonProperty("age")
    public void setAge(Age value) { this.age = value; }

    @JsonProperty("gender")
    public Gender getGender() { return gender; }
    @JsonProperty("gender")
    public void setGender(Gender value) { this.gender = value; }

    @JsonProperty("size")
    public Size getSize() { return size; }
    @JsonProperty("size")
    public void setSize(Size value) { this.size = value; }

    @JsonProperty("coat")
    public Size getCoat() { return coat; }
    @JsonProperty("coat")
    public void setCoat(Size value) { this.coat = value; }

    @JsonProperty("attributes")
    public Attributes getAttributes() { return attributes; }
    @JsonProperty("attributes")
    public void setAttributes(Attributes value) { this.attributes = value; }

    @JsonProperty("environment")
    public Environment getEnvironment() { return environment; }
    @JsonProperty("environment")
    public void setEnvironment(Environment value) { this.environment = value; }

    @JsonProperty("tags")
    public String[] getTags() { return tags; }
    @JsonProperty("tags")
    public void setTags(String[] value) { this.tags = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("organization_animal_id")
    public String getOrganizationAnimalID() { return organizationAnimalID; }
    @JsonProperty("organization_animal_id")
    public void setOrganizationAnimalID(String value) { this.organizationAnimalID = value; }

    @JsonProperty("photos")
    public Photo[] getPhotos() { return photos; }
    @JsonProperty("photos")
    public void setPhotos(Photo[] value) { this.photos = value; }

    @JsonProperty("primary_photo_cropped")
    public Photo getPrimaryPhotoCropped() { return primaryPhotoCropped; }
    @JsonProperty("primary_photo_cropped")
    public void setPrimaryPhotoCropped(Photo value) { this.primaryPhotoCropped = value; }

    @JsonProperty("videos")
    public Object[] getVideos() { return videos; }
    @JsonProperty("videos")
    public void setVideos(Object[] value) { this.videos = value; }

    @JsonProperty("status")
    public Status getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(Status value) { this.status = value; }

    @JsonProperty("status_changed_at")
    public EdAt getStatusChangedAt() { return statusChangedAt; }
    @JsonProperty("status_changed_at")
    public void setStatusChangedAt(EdAt value) { this.statusChangedAt = value; }

    @JsonProperty("published_at")
    public EdAt getPublishedAt() { return publishedAt; }
    @JsonProperty("published_at")
    public void setPublishedAt(EdAt value) { this.publishedAt = value; }

    @JsonProperty("distance")
    public Object getDistance() { return distance; }
    @JsonProperty("distance")
    public void setDistance(Object value) { this.distance = value; }

    @JsonProperty("contact")
    public Contact getContact() { return contact; }
    @JsonProperty("contact")
    public void setContact(Contact value) { this.contact = value; }

    @JsonProperty("_links")
    public AnimalLinks getLinks() { return links; }
    @JsonProperty("_links")
    public void setLinks(AnimalLinks value) { this.links = value; }
}
