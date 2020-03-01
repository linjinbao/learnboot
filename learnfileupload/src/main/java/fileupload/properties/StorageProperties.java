package fileupload.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

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

@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
