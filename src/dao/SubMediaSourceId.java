package dao;



/**
 * SubMediaSourceId entity. @author MyEclipse Persistence Tools
 */

public class SubMediaSourceId  implements java.io.Serializable {


    // Fields    

     private MediaDesc mediaDesc;
     private String mediaUrl;


    // Constructors

    /** default constructor */
    public SubMediaSourceId() {
    }

    
    /** full constructor */
    public SubMediaSourceId(MediaDesc mediaDesc, String mediaUrl) {
        this.mediaDesc = mediaDesc;
        this.mediaUrl = mediaUrl;
    }

   
    // Property accessors

    public MediaDesc getMediaDesc() {
        return this.mediaDesc;
    }
    
    public void setMediaDesc(MediaDesc mediaDesc) {
        this.mediaDesc = mediaDesc;
    }

    public String getMediaUrl() {
        return this.mediaUrl;
    }
    
    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SubMediaSourceId) ) return false;
		 SubMediaSourceId castOther = ( SubMediaSourceId ) other; 
         
		 return ( (this.getMediaDesc()==castOther.getMediaDesc()) || ( this.getMediaDesc()!=null && castOther.getMediaDesc()!=null && this.getMediaDesc().equals(castOther.getMediaDesc()) ) )
 && ( (this.getMediaUrl()==castOther.getMediaUrl()) || ( this.getMediaUrl()!=null && castOther.getMediaUrl()!=null && this.getMediaUrl().equals(castOther.getMediaUrl()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getMediaDesc() == null ? 0 : this.getMediaDesc().hashCode() );
         result = 37 * result + ( getMediaUrl() == null ? 0 : this.getMediaUrl().hashCode() );
         return result;
   }   





}