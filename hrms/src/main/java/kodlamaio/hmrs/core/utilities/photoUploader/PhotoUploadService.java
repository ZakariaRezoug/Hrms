package kodlamaio.hmrs.core.utilities.photoUploader;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.results.DataResult;

public interface PhotoUploadService {
	DataResult<Map> uploadImageFile(MultipartFile imageFile);
	
}
