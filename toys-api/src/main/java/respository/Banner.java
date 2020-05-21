package respository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Banner {

    public Long id;

    public String title;

    public String images;

    public String targetUri;

    public Integer createAt;

    public Integer updateAt;
}
