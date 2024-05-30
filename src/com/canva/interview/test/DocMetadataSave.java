package com.canva.interview.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DocMetadataSave {
    public static void main(String[] args) {
        String folderPath = "test/path"; // Replace with the actual folder path
        File folder = new File(folderPath);
        List<FileMetadata> fileMetadataList = buildFileMetadataListFromFolder(folder);

        //Sort file by last modified date use list stream
        List<FileMetadata> reverseSortedFileList = fileMetadataList.stream().sorted(Comparator.comparingLong(FileMetadata::getUploadDate).reversed()).collect(Collectors.toList());

        //Insert the file metadata into db
        insertListFilesIntoDb(reverseSortedFileList);

    }

    private static void insertListFilesIntoDb(List<FileMetadata> listFiles) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnit");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//
//        try {
//            transaction.begin();
//            listFiles.forEach(item -> {
//                entityManager.persist(item);
//            });
//            transaction.commit();
//
//        } catch (Exception e) {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//        } finally {
//            entityManager.close();
//            entityManagerFactory.close();
//        }
    }

    private static List<FileMetadata> buildFileMetadataListFromFolder(File folder) {
        List<FileMetadata> fileMetadataList = new ArrayList<>();
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.exists()) {
                        FileMetadata fileMetadata = new FileMetadata();
                        fileMetadata.setFileName(file.getName());
                        fileMetadata.setUploadDate(file.lastModified());
                        fileMetadataList.add(fileMetadata);
                    }
                }
            }
        } else {
            System.out.println("Folder does not exist or is not a directory.");
        }
        return fileMetadataList;
    }


}
