import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TableBuilder {
    ArrayList<ArrayList<String>> table = new ArrayList<>();
    ArrayList<String> headers;
    String tableString;

    public TableBuilder(ArrayList<String> headers) {
        this.headers = headers;
    }

    public void setTableData(ArrayList<ArrayList<String>> userTable) {
        this.table = userTable;

        table.addFirst(headers);

        int[] maxColWidth = new int[this.headers.size()];
        for (ArrayList<String> row : userTable) {
            for (int i = 0; i < row.size(); i++) {
                maxColWidth[i] = Math.max(maxColWidth[i], row.get(i).length());
            }
        }

        StringBuilder rowBuilder = new StringBuilder();
        for (int colWidth : maxColWidth) {
            rowBuilder.append("%-").append(colWidth + 2).append("s|");
        }

        String rowFormat = rowBuilder.toString();

        StringBuilder headerDivider = new StringBuilder();
        for (int i = 0; i < this.headers.size(); i++) {
            headerDivider.append("+");
            headerDivider.append("-".repeat(maxColWidth[i] + 2));
        }
        headerDivider.append("+\n");

        StringBuilder finalTable = new StringBuilder();
        int rowNum = 0;
        for (ArrayList<String> row : this.table) {
            finalTable.append("|").append(String.format(rowFormat, row.toArray())).append("\n");
            if (rowNum == 0) {
                finalTable.append(headerDivider.toString());
            }
            rowNum++;
        }

        this.tableString = finalTable.toString();
    }

    public void printTable() {
        System.out.println("\n" + this.tableString);
    }

    ;


}
