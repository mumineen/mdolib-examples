//
//  ContentView.swift
//  MDOXCFrameworkExample
//
//  Created by Taikhoom Attar on 6/7/21.
//

import SwiftUI
import MDOLib

func getMumbaiSunsetUTC(dateIn:Date) -> Date {
    let latM = 19.0760
    let lonM = 72.8777
    
    let outDict:Dictionary = MDOLib.roundedSalaatArray(for: dateIn, lat: latM, lon: lonM, altitude: 0.0)
    
    return outDict["maghrib"] as! Date
}

struct ContentView: View {
    var body: some View {
        VStack{
            Text("Maghrib in Mumbai:")
            Text(getMumbaiSunsetUTC(dateIn: Date()), style: .time)
            
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
