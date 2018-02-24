public class URLParamParser {
    public KeyValue[] parse(String url){
        String[] keyValueParams = url.split("&");

        KeyValue[] keyValueArray = new KeyValue[keyValueParams.length];

        for (int i = 0; i < keyValueParams.length; i++) {
            String keyValueParam = keyValueParams[i];

            if (countOfSymbol(keyValueParam, '=') != 1){
                throw new IllegalArgumentException("Format of key-value pair has to be 'key=value'");
            }

            String[] keyAndValue = keyValueParam.split("=");

            String key = keyAndValue[0];

            if (key.isEmpty()){
                throw new IllegalArgumentException("Key has to be not empty");
            }

            for (int j = 0; j < i; j++) {
                if (key.equalsIgnoreCase(keyValueArray[j].getKey())) {
                    throw new IllegalArgumentException("Key mustn't repeat");
                }
            }

            //TODO check that key doesn't repeat

            String value = keyAndValue.length == 1 ? "" : keyAndValue[1];

            keyValueArray[i] = new KeyValue(key, value);
        }



        return keyValueArray;
    }

    private int countOfSymbol(String string, char symbol){
        char[] appearEqual = string.toCharArray();
        int counter = 0;
        for (char c : appearEqual) {
            if (c == symbol){
                counter++;
            }
        }
        return counter;
    }
}
