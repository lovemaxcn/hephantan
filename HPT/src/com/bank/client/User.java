/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.client;


import com.bank.commonatm.Bank;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang Ha
 */
public class User {
    Bank bank;
    public static void main(String[] args) {
//        try {
//            Registry registry = LocateRegistry.getRegistry("localhost",1996);
//            Bank bank=(Bank) registry.lookup("atm");
//            ArrayList<String> loi;
//            Account account = bank.getAccount("vyy0yDskCKwK","164578811");
//            System.out.println("Trước khi gửi tiền");
//            System.out.println("Tên người dùng : "+account.getNameUser());
//            System.out.println("Số dư : "+account.getBalance());
//            //gửi tiền
//            loi = bank.deposit("vyy0yDskCKwK","164578811", 1);
//            if(loi.size()>0){
//                System.out.println("Gửi tiền không thành công do : ");
//                for(int i=0;i<loi.size();i++){
//                    System.out.println("\t+"+loi.get(i));
//                }
//            }else{
//                System.out.println("Gửi tiền thành công!");
//                account = bank.getAccount("vyy0yDskCKwK","164578811");
//                System.out.println("Sau khi gửi tiền");
//                System.out.println("Tên người dùng : "+account.getNameUser());
//                System.out.println("Số dư : "+account.getBalance());
//            }
//           
//            //rút tiền
//            loi = bank.withdraw("vyy0yDskCKwK","164578811", 0);
//            
//            if(loi.size()>0){
//                System.out.println("Rút tiền không thành công do : ");
//                for(int i=0;i<loi.size();i++){
//                    System.out.println("\t+"+loi.get(i));
//                }
//            }else{
//                System.out.println("Rút tiền thành công!");
//                account = bank.getAccount("vyy0yDskCKwK","164578811");
//                System.out.println("Sau khi rút tiền");
//                System.out.println("Tên người dùng : "+account.getNameUser());
//                System.out.println("Số dư : "+account.getBalance());
//            }
//        } catch (RemoteException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NotBoundException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    public User(){
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry("localhost",1996);
            bank=(Bank) registry.lookup("atm");
        } catch (RemoteException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
