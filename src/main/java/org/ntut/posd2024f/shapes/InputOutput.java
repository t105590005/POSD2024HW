package org.ntut.posd2024f.shapes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class InputOutput {

    public InputOutput() {
    }

    public ArrayList<Shape> handleInput(String inputFileName) throws NumberFormatException, Exception {
        ArrayList<Shape> shapes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Shape shape = ConstructShape(line);
                    if (shape != null) {
                        shapes.add(shape);
                    }
                } catch (Exception e) {
                    // Ignore invalid shapes
                }
            }
        } catch (IOException e) {
            throw new Exception("Error reading input file");
        }
        return shapes;
    }

    public ArrayList<Shape> handleSort(ArrayList<Shape> shapes, String compare, String order) {
        if (compare.equalsIgnoreCase("area")) {
            if (order.equalsIgnoreCase("inc")) {
                Collections.sort(shapes, Sort.BY_AREA_ASCENDING);
            } else if (order.equalsIgnoreCase("dec")) {
                Collections.sort(shapes, Sort.BY_AREA_DESCENDING);
            }
        } else if (compare.equalsIgnoreCase("perimeter")) {
            if (order.equalsIgnoreCase("inc")) {
                Collections.sort(shapes, Sort.BY_PERIMETER_ASCENDING);
            } else if (order.equalsIgnoreCase("dec")) {
                Collections.sort(shapes, Sort.BY_PERIMETER_DESCENDING);
            }
        }
        return shapes;
    }

    public void handleOutput(ArrayList<Shape> shapes, String outputFileName) {
        try (PrintWriter writer = new PrintWriter(new File(outputFileName))) {
            for (Shape shape : shapes) {
                writer.println(shape.toString());
            }
        } catch (IOException e) {
            System.err.println("Error writing to output file: " + e.getMessage());
        }
    }

    private Shape ConstructShape(String str) throws NumberFormatException, Exception {
        String[] parts = str.split(" ");
        System.out.println(parts);
        switch (parts[0]) {
            case "Circle":
                if (parts.length != 2)
                    throw new Exception("It's not a circle!");
                return new Circle(Double.parseDouble(parts[1]));
            case "Rectangle":
                if (parts.length != 3)
                    throw new Exception("It's not a rectangle!");
                return new Rectangle(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
            case "Triangle":
                if (parts.length != 4)
                    throw new Exception("It's not a triangle!");
                return new Triangle(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3]));
            default:
                return null;
        }
    }
}
