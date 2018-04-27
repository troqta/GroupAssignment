package com.calendar.Menus;

import com.calendar.DashBoard;

public abstract class  Menu {
    private DashBoard dashBoard;

    public Menu(DashBoard dashBoard) {
        this.dashBoard = dashBoard;
    }

    public DashBoard getDashBoard() {
        return dashBoard;
    }

    public void setDashBoard(DashBoard dashBoard) {
        this.dashBoard = dashBoard;
    }

    public abstract void printMenu();
    public abstract void selectOptions();
}
