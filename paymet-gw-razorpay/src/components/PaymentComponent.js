import React, { useState, useEffect } from 'react';

import useRazorpay from "react-razorpay";

const PaymentComponent = () => {
  const [amount, setAmount] = useState(0);
  const [userName, setUserName] = useState('');
  const [email, setEmail] = useState('');
  const [contact, setContact] = useState('');

  const [Razorpay] = useRazorpay();

  useEffect(() => {
    // Set initial amount or update it as needed
    setAmount(3); // Example: set initial amount to 100
  }, []); // Run this effect only once on component mount

  const createOrder = async () => {
    try {

      const response = await fetch(`http://localhost:8080/payment/${amount * 100}`, {
        method: 'GET',
      });
      if (!response.ok) {
        throw new Error(`Failed to fetch data agian: ${response.statusText}`);
      }
      console.log('repsonses new>>>');
      try{
        
      const data = await response.text(); // Assuming the response is in JSON format
      if(data){
        console.log('inside creae ordr inser tinerts>>>',data);
      }
      console.log('inside creae ordr>>>',data);
      return data.orderId; // Replace 'orderId' with the actual key from the response
      }catch(error){
        throw new Error('Invalid JSON format in the response');
      }
    } catch (error) {
      console.error('Error creating order:', error);
      throw error; // Propagate the error if needed
    }
  };

  const handlePayment = async () => {
    try {
      const order = await createOrder();
      console.log('some issue-1');
      const options = {
        key: 'rzp_test_ow8inFuS1Ngbpl',
        amount: amount * 100,
        currency: 'INR',
        name: userName,
        description: 'Test Transaction-1',
        image: 'https://razorpay.com/blog-content/uploads/2020/09/authentication.png',
        order_id: order,
        handler: function (response) {
          alert(response.razorpay_payment_id);
          alert(response.razorpay_order_id);
          alert(response.razorpay_signature);
        },
        prefill: {
          name: userName,
          email: email,
          contact: contact,
        },
        notes: {
          address: 'ABC, Delhi',
        },
        theme: {
          color: '#3399cc',
        },
      };
      console.log('some issue-2');
      const rzp1 = new Razorpay(options);
      console.log('some issue-3');
      rzp1.on('payment.failed', function (response) {
        alert(response.error.code);
        alert(response.error.description);
        alert(response.error.source);
        alert(response.error.step);
        alert(response.error.reason);
        alert(response.error.metadata.order_id);
        alert(response.error.metadata.payment_id);
      });
      console.log('some issue-4');
      rzp1.open();
    } catch (error) {
      console.error('Error handling payment:', error);
      // Handle the error as needed (show an error message, etc.)
    }
  };

  return (
    <div>
      <h1>Razorpay Payment</h1>
      <form>
        {/* Add your form inputs here (name, email, contact, etc.) */}
        <button type="button" onClick={handlePayment}>
          Make Payment
        </button>
      </form>
    </div>
  );
};

export default PaymentComponent;
