/*package com.example.dao;

import com.example.Manufacture;
import com.example.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@ManagedResource
@Service
public class SchedulerService  {
    private static String workerFIle = "directory\\worker.txt";
    private static String manufactureFile = "directory\\manufacture.txt";
    @Autowired
    private WorkerService workerService;

    @Autowired
    private ManufactureService manufactureService;

    @Scheduled(cron = "0 *///30 * * * *")
 /*   @ManagedOperation
    public void updateItemFile() {
        for (File myFile : new File("directory").listFiles()) {
            if (myFile.isFile()) myFile.delete();
        }
        try {
            File worker = new File(workerFIle);
            File manufacture = new File(manufactureFile);
            worker.createNewFile();
            manufacture.createNewFile();
            FileWriter fw1 = new FileWriter(worker);
            FileWriter fw2 = new FileWriter(manufacture);
            List<Worker> workers = workerService.index();
            List<Manufacture> manufactures  = manufactureService.index();
            String text = "";
            for (Worker i: workers){
                text += i.getFirstName() + " " +
                        i.getMiddleName() + " " + i.getLastName() + "\n";
            }
            fw1.write(text);
            text = "";
            for (Manufacture i: manufactures){
                text += i.getName() + " " + i.getAddress() + "\n";
            }
            fw2.write(text);
            fw1.flush();
            fw2.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

  */

