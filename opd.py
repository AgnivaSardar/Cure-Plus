# import flask

from flask import Flask, render_template
from flask_mysqldb import MySQL

app = Flask(__name__)
app.config['MYSQL_HOST'] = 'localhost'
app.config['MYSQL_USER'] = 'dbuser'
app.config['MYSQL_PASSWORD'] = 'AgniAdri@1507'
app.config['MYSQL_DB'] = 'opd_booking'

mysql = MySQL(app)

@app.route("/OPD.html") 
def opd():
    cur = mysql.connection.cursor()
    cur.execute("SELECT * FROM opd_doctors")
    fetchdata = cur.fetchall()
    cur.close() 
    return render_template('OPD.html', data = fetchdata)

@app.route("/book.html") 
def opd_time_table():
    cur = mysql.connection.cursor()
    cur.execute("SELECT * FROM opd_doctors")
    fetchdata = cur.fetchall()
    cur.close() 
    cur1 = mysql.connection.cursor()
    cur1.execute("SELECT * FROM time_table")
    fetchdata1=cur1.fetchall()
    cur1.close()
    
    return render_template('book.html', data = fetchdata, data1 = fetchdata1)

@app.route("/book_appointment.html") 
def bpd_form():
    cur = mysql.connection.cursor()
    cur.execute("SELECT * FROM opd_doctors")
    fetchdata = cur.fetchall()
    cur.close() 
    cur1 = mysql.connection.cursor()
    cur1.execute("SELECT * FROM time_table")
    fetchdata1=cur1.fetchall()
    cur1.close()
    
    return render_template('book_appointment.html', data = fetchdata, data1 = fetchdata1)

app.run(debug=True)