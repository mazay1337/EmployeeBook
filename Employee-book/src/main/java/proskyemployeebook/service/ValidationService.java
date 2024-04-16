package proskyemployeebook.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import proskyemployeebook.exception.IncorrectNameException;


@Service
public class ValidationService {

    public String validate(String name) {
        if (!StringUtils.isAlpha(name)) {
            throw new IncorrectNameException();
        }
        return StringUtils.capitalize(StringUtils.lowerCase(name));
    }
}
