package name.yalsooni.genius.definition;

/**
 * 지니어스 서비스 정의
 *
 * @author ijyoon
 */
public interface Service {

    /**
     * 초기화
     *
     * @throws Exception
     */
    void initialize() throws Exception;

    /**
     * 실행
     *
     * @throws Exception
     */
    void execute() throws Exception;

}
