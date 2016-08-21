package dao;



/**
 * SubMediaSource entity. @author MyEclipse Persistence Tools
 */

public class SubMediaSource  implements java.io.Serializable {


    // Fields    

     private SubMediaSourceId id;
     private Integer order1;


    // Constructors

    /** default constructor */
    public SubMediaSource() {
    }

    
    /** full constructor */
    public SubMediaSource(SubMediaSourceId id, Integer order1) {
        this.id = id;
        this.order1 = order1;
    }

   
    // Property accessors

    public SubMediaSourceId getId() {
        return this.id;
    }
    
    public void setId(SubMediaSourceId id) {
        this.id = id;
    }

    public Integer getOrder1() {
        return this.order1;
    }
    
    public void setOrder1(Integer order1) {
        this.order1 = order1;
    }
   








}