package org.controller;



import org.controller.CRUD.SelectData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SelectController {
    public String menuSelectController(DefaultTableModel tableModel){
        return new SelectData().menuSelectData(tableModel);
    }
}
