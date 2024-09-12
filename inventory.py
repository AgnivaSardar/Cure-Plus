from flask import Flask, render_template
from flask_mysqldb import MySQL

app = Flask(__name__)
app.config['MYSQL_HOST'] = 'localhost'
app.config['MYSQL_USER'] = 'dbuser'
app.config['MYSQL_PASSWORD'] = 'AgniAdri@1507'
app.config['MYSQL_DB'] = 'inventory'

mysql = MySQL(app)

@app.route("/inventory.html") 
def stock_mgt():
    cur = mysql.connection.cursor()
    cur.execute("SELECT * FROM stock_mgt")
    fetchdata = cur.fetchall()
    cur.close() 
    return render_template('inventory.html', data = fetchdata)

@app.route("/create_order.html") 
def create_order():
    cur = mysql.connection.cursor()
    cur.execute("SELECT * FROM create_order")
    fetchdata = cur.fetchall()
    cur.close() 
    return render_template('create_order.html', data = fetchdata)

app.run(debug=True)