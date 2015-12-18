package name.yalsooni.genius.replace;


import name.yalsooni.common.util.support.Log;
import name.yalsooni.genius.definition.ErrCode;
import name.yalsooni.genius.replace.vo.StringReplaceInfo;

/**
 * 엑셀파일을 기반으로 특정 탬플릿 파일의 단어를 치환시켜 준다.
 * 1. 지니어스 프로퍼티 파일 경로.
 *
 * @author ijyoon
 */
public class StringReplaceExecutor {

    public static void main(String[] args) {

        if (args.length < 1 || args[0] == null) {
            Log.console("파라미터 값을 입력하세요.");
            Log.console("1. genius property file path");
            return;
        }

        long startTime = System.currentTimeMillis();

        try {

            StringReplaceInfo info = new StringReplaceInfo();

            info.setPropertyFilePath(args[0]);

            Log.console(" ** StringPattern Start. **  Elasped Time : ");

            StringReplace sp = new StringReplace(info);
            try {
                sp.initialize();
            }catch (Exception e){
                throw new Exception(ErrCode.G01_0001, e);
            }
            Log.console(" StringPattern initialize done.");

            try {
                sp.execute();
            }catch (Exception e){
                throw new Exception(ErrCode.G01_0002, e);
            }
            Log.console(" StringPattern execute done.");

        } catch (Exception e) {
            Log.console(e.getMessage(), e);
        } finally {
            Log.console(" ** StringPattern End. **  Elasped Time : " + (System.currentTimeMillis() - startTime) + " ms");
        }

    }

}
