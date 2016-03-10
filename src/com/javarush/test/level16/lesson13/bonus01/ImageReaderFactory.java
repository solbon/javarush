package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

import java.util.IllegalFormatException;

/**
 * Created by solbon on 29.08.2014.
 */
public class ImageReaderFactory {

    public static ImageReader getReader(ImageTypes imageTypes) throws IllegalArgumentException {
            if (imageTypes == ImageTypes.BMP)
                return new BmpReader();
            if (imageTypes == ImageTypes.JPG)
                return new JpgReader();
            if (imageTypes == ImageTypes.PNG)
                return new PngReader();
            else
                throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
