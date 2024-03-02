package com.yc.csp;

import java.util.Scanner;

public class CoordinateTransform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 操作数量
        int m = scanner.nextInt(); // 查询数量
        double[] stretch = new double[n + 1]; // 拉伸前缀积向量
        double[] rotation = new double[n + 1]; // 旋转前缀和向量

        stretch[0] = 1;
        rotation[0] = 0;

        for (int i = 1; i <= n; i++) {
            int operation = scanner.nextInt();
            double value = scanner.nextDouble();
            if (operation == 1) {
                // 拉伸操作
                stretch[i] = stretch[i - 1] * value;
                rotation[i] = rotation[i - 1];
            } else {
                // 旋转操作
                stretch[i] = stretch[i - 1];
//                rotation[i] = (rotation[i - 1] + value) % (2 * Math.PI);
                rotation[i] = rotation[i - 1] + value;
            }
        }

        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();

            double totalRotation = rotation[r] - rotation[l - 1];
            double totalStretch = stretch[r] / stretch[l - 1];

            double newX = (x * Math.cos(totalRotation) - y * Math.sin(totalRotation)) * totalStretch;
            double newY = (x * Math.sin(totalRotation) + y * Math.cos(totalRotation)) * totalStretch;

            System.out.printf("%.3f %.3f\n", newX, newY);
        }

    }
}



//法二：运行时间为2s
//
//
//import java.util.Scanner;
///*
// * 极坐标+前缀和 O(m + n) 100分
// * */
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        double[] side = new double[n + 1]; //坐标伸缩量的前缀和
//        double[] rad = new double[n + 1];    //弧度变化量的前缀和
//        side[0] = 1.0;
//        //预处理前缀和数组
//        for (int i = 1; i < n + 1; i++) {
//            int type = sc.nextInt();
//            double delta = sc.nextDouble();
//            if (type == 1) {
//                side[i] = delta * side[i - 1];
//                rad[i] = rad[i - 1];
//            } else {
//                rad[i] = delta + rad[i - 1];
//                side[i] = side[i - 1];
//            }
//        }
//        for (int i = 0; i < m; i++) {
//            int start = sc.nextInt();
//            int end = sc.nextInt();
//            double x = sc.nextDouble();
//            double y = sc.nextDouble();
//            //起始点的极坐标r,Θ
//            double r = Math.sqrt(x * x + y * y);
//            double theta = Math.atan2(y, x);
//            //执行start到end的一系列操作
//            r *= side[end] / side[start - 1];
//            theta += rad[end] - rad[start - 1];
//            //最后得出该点的平面直角坐标
//            x = r * Math.cos(theta);
//            y = r * Math.sin(theta);
//            System.out.println(x + " " + y);
//        }
//    }
//}
