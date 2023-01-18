package com.epam.mjc;

import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        StringTokenizer string = new StringTokenizer(signatureString, "(, )");
        String publicTest = "public";
        String privateTest = "private";
        MethodSignature methodSignature = new MethodSignature(signatureString);
        String firstTokenCheck = "";
        firstTokenCheck = string.nextToken();
        if (firstTokenCheck.equals(publicTest) || firstTokenCheck.equals(privateTest)){
            methodSignature.setAccessModifier(firstTokenCheck);
            methodSignature.setReturnType(string.nextToken());
        } else {
            methodSignature.setAccessModifier(null);
            methodSignature.setReturnType(firstTokenCheck);
        }
        methodSignature.setMethodName(string.nextToken());
        int tokensLeft = string.countTokens()/2 - 1;
        for (int i = 0; i <= tokensLeft; i++){
            methodSignature.getArguments().add(i, new MethodSignature.Argument(string.nextToken(), string.nextToken()));
        }
        return methodSignature;
    }
}
