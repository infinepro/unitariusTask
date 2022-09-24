
public class Main {

    public String[] execute(String[] arr, int m) {
        var leftBlockLength = m;
        var rightBlockLength = arr.length - m;

        if (leftBlockLength == 0 || rightBlockLength == 0) {
            return arr;
        }

        var leftBlockStartIndex = 0;
        var leftBlockEndIndex = m - 1;

        var rightBlockStartIndex = m;
        var rightBlockEndIndex = arr.length - 1;

        while (true) {
            if (leftBlockLength < rightBlockLength) {
                moveLeftBlockToRight(arr, leftBlockStartIndex, leftBlockEndIndex, leftBlockLength);

                rightBlockLength = Math.abs(rightBlockLength - leftBlockLength);
                rightBlockStartIndex += leftBlockLength;
                leftBlockStartIndex += leftBlockLength;
                leftBlockEndIndex += leftBlockLength;
            } else if (leftBlockLength > rightBlockLength) {
                moveRightBlockToLeft(arr, rightBlockStartIndex, rightBlockEndIndex, rightBlockLength);

                leftBlockLength = Math.abs(leftBlockLength - rightBlockLength);
                leftBlockEndIndex -= rightBlockLength;
                rightBlockStartIndex -= rightBlockLength;
                rightBlockEndIndex -= rightBlockLength;
            } else {
                // меняем местами последние 2 символа
                moveLeftBlockToRight(arr, leftBlockStartIndex, leftBlockEndIndex, leftBlockLength);
                return arr;
            }
        }
    }

    private void moveRightBlockToLeft(String[] arr, int blockStartIndex, int blockEndIndex, int currentBlockLength) {
        String tmp;
        for (int i = blockEndIndex; i >= blockStartIndex; i--) {
            tmp = arr[i - currentBlockLength];
            arr[i - currentBlockLength] = arr[i];
            arr[i] = tmp;
        }
    }

    private void moveLeftBlockToRight(String[] arr, int blockStartIndex, int blockEndIndex, int currentBlockLength) {
        String tmp;
        for (int i = blockStartIndex; i <= blockEndIndex; i++) {
            tmp = arr[i + currentBlockLength];
            arr[i + currentBlockLength] = arr[i];
            arr[i] = tmp;
        }
    }
}