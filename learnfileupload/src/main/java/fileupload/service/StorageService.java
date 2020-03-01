package fileupload.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author linjinbao66@gmail.com
 * date 2020-03-01
 * @apiVersion
 * @apiGroup
 * @apiDescription
 * @apiParam
 * @apiParamExample
 * @apiSuccess (200)
 * @apiSuccessExample
 */
public interface StorageService {

    void init();

    void store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

}
