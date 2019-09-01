/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Thu Trang
 */
public class QLNV extends javax.swing.JFrame {

    ArrayList<NV> list = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel();
    int index;

    public QLNV() {
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) tblBang.getModel();
        list.add(new NV("Ph05730", "Nguyễn Văn Lộc", "loc1@gmail.com", 19, 5000000));
        list.add(new NV("Ph05960", "Trần Hoàng Nam", "Nam1@gmail.com", 19, 9500000));
        list.add(new NV("Ph05760", "Nguyễn Thị Nhung", "nhung1@gmail.com", 23, 7500000));
        list.add(new NV("Ph01230", "Phạm Văn Hoàng", "Hoàng1@gmail.com", 26, 450000));
        fillToTable();
        display(index);
        time();

    }

    public void fillToTable() {
        model.setRowCount(0);
        for (NV nvien : list) {
            Object[] row = new Object[]{nvien.MNV, nvien.HoTen, nvien.Tuoi, nvien.Email, nvien.Luong};
            model.addRow(row);
        }
        showDetail();
    }

    public void display(int index) {
        txtMNV.setText(list.get(index).getMNV() + "");
        txtHoTen.setText(list.get(index).getHoTen() + "");
        txtEmail.setText(list.get(index).getEmail() + "");
        txtTuoi.setText(list.get(index).getTuoi() + "");
        txtLuong.setText(list.get(index).getLuong() + "");
        Message.setText("Record: " + (index + 1) + "/" + list.size());
        tblBang.setRowSelectionInterval(index, index);
        
    }

    public void showDetail() {
        int index = tblBang.getSelectedRowCount();
        NV nv = list.get(index);
        txtMNV.setText((String) tblBang.getValueAt(index, 0));
        txtHoTen.setText((String) tblBang.getValueAt(index, 1));
        txtTuoi.setText(tblBang.getValueAt(index, 2).toString());
        txtEmail.setText((String) tblBang.getValueAt(index, 3));
        txtLuong.setText(tblBang.getValueAt(index, 4).toString());
    }
    public boolean readFile(String filename) {
        try {
            try (
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

                list = (ArrayList<NV>) ois.readObject();
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean writeFile(String filename) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(list);
            oos.flush();
            oos.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gap loi" + e);
            return false;
        }

    }

    private void addTable() {
        model.setRowCount(0);
        list.forEach((x) -> {
            model.addRow(new Object[]{x.getMNV(), x.getHoTen(), x.getTuoi(), x.getEmail(), x.getLuong()});
        });

        if (model.getRowCount() > 0) {
            tblBang.setRowSelectionInterval(0, 0);
        }
    }

    public void addEmployee() {
        list.add(new NV(txtMNV.getText(), txtHoTen.getText(), txtEmail.getText(), Integer.parseInt(txtTuoi.getText()), Long.parseLong(txtLuong.getText())));
        index = list.size() - 1;
        model.addRow(new Object[]{txtMNV.getText(), txtHoTen.getText(), txtTuoi.getText(), txtEmail.getText(), txtLuong.getText()});
        display(index);
        JOptionPane.showMessageDialog(null, "Thêm thành công");
    }

    public void updateEmployee() {
        list.get(index).setMNV(txtMNV.getText());
        list.get(index).setHoTen(txtHoTen.getText());
        list.get(index).setTuoi(Integer.parseInt(txtTuoi.getText()));
        list.get(index).setEmail(txtEmail.getText());
        list.get(index).setLuong(Long.parseLong(txtLuong.getText()));
        fillToTable();
        display(index);
        JOptionPane.showMessageDialog(null, "cập nhật thành công");
    }
    public boolean testid(String ID) {
        if (index == -1) {
            for (NV nv : list) {
                if (ID.equalsIgnoreCase(nv.getMNV())) {
                    return false;
                }
            }
        } else {
            for (NV nv : list) {
                if (!(list.get(index).getMNV().equalsIgnoreCase(nv.getMNV()))) {
                    if (nv.getMNV().equalsIgnoreCase(ID)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void saveFile() {
        try {
            if (txtMNV.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Không được để trống ID");
                txtMNV.requestFocus();
                return;
            } else if (!testid(txtMNV.getText())) {
                JOptionPane.showMessageDialog(null, "ID đã tồn tại");
                txtMNV.requestFocus();
                return;
            } else if (txtHoTen.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Không được để trống họ tên");
                txtHoTen.requestFocus();
                return;
            } else if (txtTuoi.getText().length() == 0 || Integer.parseInt(txtTuoi.getText()) <= 18 || Integer.parseInt(txtTuoi.getText()) >= 44) {
                JOptionPane.showMessageDialog(null, "Tuổi từ 18 đến 55");
                txtTuoi.requestFocus();
                return;
            } else if (!txtEmail.getText().matches("\\w+@\\w+(\\.\\w+){1,2}")) {
                JOptionPane.showMessageDialog(null, "email không đúng định dạng");
                txtEmail.requestFocus();
                return;
            } else if (Long.parseLong(txtLuong.getText()) < 5000000) {
                JOptionPane.showMessageDialog(null, "Lương phải trên 5 triệu");
                txtLuong.requestFocus();
                return;
            }
            if (index == -1) {
                addEmployee();
            } else {
                updateEmployee();
            }
          
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Định dạng số không đúng");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "lỗi: " + e);
        }
    }

    public void time() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        SimpleDateFormat ad = new SimpleDateFormat();
                        Date date = new Date();
                        ad.applyPattern("hh:mm:ss aa");
                        String text = ad.format(date);
                        lblTime.setText(text);
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        t1.start();
    }
    public void clearForm() {
        txtMNV.setText("");        // TODO add your handling code here:
        txtHoTen.setText("");        // TODO add your handling code here:
        txtTuoi.setText("");        // TODO add your handling code here:
        txtEmail.setText("");        // TODO add your handling code here:
        txtLuong.setText("");
//        Message.setText("Record: ....");
//        index = -1;
    }

    public int findEmployee(String ma) {
        for (NV nv : list) {
            if (nv.getMNV().equalsIgnoreCase(ma)) {
                return list.indexOf(nv);
            }
        }
        return -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMNV = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        btnBandau = new javax.swing.JButton();
        btnQuaylai = new javax.swing.JButton();
        btnTiep = new javax.swing.JButton();
        btnCuoicung = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        Message = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btntheomsv = new javax.swing.JButton();
        btntheotuoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÍ NHÂN VIÊN");

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MANV", "HỌ TÊN", "TUỔI", "EMAIL", "LƯƠNG"
            }
        ));
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("QUẢN LÍ  NHÂN VIÊN");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("MÃ NV");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("HỌ TÊN");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("TUỔI");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("EMAIL");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("LƯƠNG");

        btnBandau.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnBandau.setText("|<");
        btnBandau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBandauActionPerformed(evt);
            }
        });

        btnQuaylai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnQuaylai.setText("<<");
        btnQuaylai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuaylaiActionPerformed(evt);
            }
        });

        btnTiep.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTiep.setText(">>");
        btnTiep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiepActionPerformed(evt);
            }
        });

        btnCuoicung.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCuoicung.setText(">|");
        btnCuoicung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoicungActionPerformed(evt);
            }
        });

        lblTime.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 51, 51));

        Message.setForeground(new java.awt.Color(255, 51, 51));

        btnNew.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnNew.setText("NEW");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnFind.setText("FIND");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnOpen.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnOpen.setText("OPEN");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete)
                            .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnFind)
                .addGap(18, 18, 18)
                .addComponent(btnOpen)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btntheomsv.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btntheomsv.setText("XẮP XẾP THEO TÊN");
        btntheomsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntheomsvActionPerformed(evt);
            }
        });

        btntheotuoi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btntheotuoi.setText("XẮP XẾP THEO TUỔI");
        btntheotuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntheotuoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBandau))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnQuaylai)
                                        .addGap(38, 38, 38)
                                        .addComponent(btnTiep)
                                        .addGap(42, 42, 42)
                                        .addComponent(btnCuoicung)
                                        .addGap(26, 26, 26)
                                        .addComponent(Message, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTuoi, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtMNV, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btntheomsv, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(122, 122, 122)
                                .addComponent(btntheotuoi)))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(txtMNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBandau)
                                .addComponent(btnQuaylai)
                                .addComponent(btnTiep)
                                .addComponent(btnCuoicung))
                            .addComponent(Message, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntheomsv)
                    .addComponent(btntheotuoi))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuaylaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuaylaiActionPerformed
        try {
            if (index > 0) {
                index--;
                display(index);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "LỖi di chuyển" + e);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuaylaiActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        this.clearForm();
        index = -1;
        //this.fillToTable();// TODO add your handling code here:
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            saveFile();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gặp lỗi" + e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnTiepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiepActionPerformed
        try {
            if (index < list.size() - 1) {
                index++;
                display(index);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "LỖi di chuyển");

        }

    }//GEN-LAST:event_btnTiepActionPerformed

    private void btnBandauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBandauActionPerformed
       try {
            index = 0;
            display(index);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi di chuyển" + e);

        }
    }//GEN-LAST:event_btnBandauActionPerformed

    private void btnCuoicungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoicungActionPerformed
        try {
            index = list.size() - 1;
            display(index);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi di chuyển" + e);

        }   // TODO add your handling code here:
    }//GEN-LAST:event_btnCuoicungActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed

            try {
            String ma = JOptionPane.showInputDialog("mời bạn nhập mã");
            index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).MNV.equalsIgnoreCase(ma)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy  mã ");
            } else {
                display(index);
                JOptionPane.showMessageDialog(null, "Tim kiem thanh cong " + ma);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gặp loi" + e);
        }
        this.fillToTable();

//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        try {
            JFileChooser chooser = new JFileChooser();
            int chon = chooser.showOpenDialog(this);
            if (chon == JFileChooser.APPROVE_OPTION) {
                String filename = chooser.getSelectedFile().getAbsolutePath();
                boolean kq = readFile(filename);
                if (kq) {
                    JOptionPane.showMessageDialog(null, "Doc du lieu thanh cong");
                    addTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Doc du lieu that bai");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gap loi" + e);
        }
        this.fillToTable();
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
       try {
            int result = JOptionPane.showConfirmDialog(null, "Ban co muon ghi lai cac thay doi");
            if (result == JOptionPane.OK_OPTION) {
                JFileChooser chooser = new JFileChooser();
                int chon = chooser.showSaveDialog(this);
                if (chon == JFileChooser.APPROVE_OPTION) {
                    String filename = chooser.getSelectedFile().getAbsolutePath();
                    boolean kq = writeFile(filename);
                    if (kq) {
                        JOptionPane.showMessageDialog(null, "Ghi du lieu thanh cong");
                        System.exit(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ghi du lieu that bai");
                    }
                }
            } else {
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gap loi: " + e);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        index = tblBang.getSelectedRow();
        list.remove(index);
        fillToTable();
        clearForm();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        try {
            index = tblBang.getSelectedRow();
            display(index);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gap loi" + e);
        }
    }//GEN-LAST:event_tblBangMouseClicked

    private void btntheomsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntheomsvActionPerformed
this.orderByTen();
this.fillToTable();        // TODO add your handling code here:
    }//GEN-LAST:event_btntheomsvActionPerformed

    private void btntheotuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntheotuoiActionPerformed
this.orderByTuoi();
this.fillToTable();        // TODO add your handling code here:
    }//GEN-LAST:event_btntheotuoiActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLNV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Message;
    private javax.swing.JButton btnBandau;
    private javax.swing.JButton btnCuoicung;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnQuaylai;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTiep;
    private javax.swing.JButton btntheomsv;
    private javax.swing.JButton btntheotuoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMNV;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
public void  orderByTen(){
        Comparator<NV> com=new Comparator<NV>() {

            @Override
            public int compare(NV o1, NV o2) {
               
            return o1.HoTen.compareTo(o2.HoTen);}
        };
      Collections.sort(list,com); // TODO add your handling code here:
    } 
    public void orderByTuoi(){
        Comparator<NV> com=new  Comparator<NV>(){

            @Override
            public int compare(NV o1, NV o2) {
               Integer d1=o1.Tuoi ;
                Integer d2=o2.Tuoi; 
            return d1.compareTo(d2);
            }  
        };
       Collections.sort(list,com);        
    }
}
