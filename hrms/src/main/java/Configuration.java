

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;


@org.springframework.context.annotation.Configuration
public class Configuration {
   
   

    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "daxxsrbve",
                "api_key", "653374188913198",
                "api_secret", "bqyReiX13BwSEXZUeLxOSXHoSVM"));
    }
}