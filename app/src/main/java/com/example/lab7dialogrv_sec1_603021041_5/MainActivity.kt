package com.example.lab7dialogrv_sec1_603021041_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.myweb.lab7dialogrv.StudentsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.edit_age
import layout.Student

class MainActivity : AppCompatActivity() {
    val studentList = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testStudentData()
        recycler_view.adapter = StudentsAdapter(this.studentList,applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.itemAnimator = DefaultItemAnimator()
    }
    fun addStudent(v: View) {

        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setView(mDialogView)
        val mAlertDialog = mBuilder.show()

        mDialogView.btnAdd.setOnClickListener {
            studentList.add(
                Student(
                    mDialogView.edit_id.text.toString(), mDialogView.edit_name.text.toString(),
                    mAlertDialog.edit_age.text.toString().toInt()
                )
            )
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(applicationContext, "The student is added successdully", Toast.LENGTH_SHORT).show()
            mAlertDialog.dismiss()
        }
        mDialogView.btnCancle.setOnClickListener() {
            mAlertDialog.dismiss()
        }
    }
    fun testStudentData(){
        studentList.add(Student( "603021041-5", "Student 1", 20))
        studentList.add(Student( "603021041-5", "Student 2", 21))
    }
}
