package kodlamaio.hmrs.core.utilities.photoUploader;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
@Service
public class PhotoUploadManager implements PhotoUploadService {
	
	private Cloudinary cloudinary;
	
	public PhotoUploadManager() {
		
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "daxxsrbve",
				"api_key", "653374188913198",
				"api_secret", "bqyReiX13BwSEXZUeLxOSXHoSVM"));
		
	}
		
	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>();
	}

}
