package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        List<Integer> sum = new ArrayList<>();
        dfs(sum, id, employeeMap);
        int res = 0;
        for (Integer integer : sum) {
            res += integer;
        }
        return res;
    }

    private void dfs(List<Integer> sum, int id, Map<Integer, Employee> employeeMap) {
        Employee employee = employeeMap.get(id);
        if (employee == null) {
            return;
        }
        sum.add(employee.importance);
        employee.subordinates.forEach(integer -> dfs(sum, integer, employeeMap));
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.id = 1;
        employee.importance = 5;
        employee.subordinates = new ArrayList<>();
        employee.subordinates.add(2);
        employee.subordinates.add(3);

        Employee employee1 = new Employee();
        employee1.id = 2;
        employee1.importance = 3;
        employee1.subordinates = new ArrayList<>();

        Employee employee2 = new Employee();
        employee2.id = 3;
        employee2.importance = 3;
        employee2.subordinates = new ArrayList<>();

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);
        EmployeeImportance employeeImportance = new EmployeeImportance();
        System.out.println(employeeImportance.getImportance(employeeList, 1));
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
