package tests.watchservice;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.WatchService;

/**
 * Created by sdaribazaron on 2016-04-21.
 */
public class MyWatchService {

    private WatchService watcher;


    private void init() throws IOException{
        watcher = FileSystems.getDefault().newWatchService();
    }


}
