package org.example.exceptions;

public class CopyFileNotFoundException extends Throwable{
    @Override
    public void printStackTrace() {
        System.out.println("Ошибка! Указанного файла не существует");
    }
}
