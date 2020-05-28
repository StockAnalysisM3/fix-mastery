import React from 'react';

const MessageInstance = ({message}) => (
    <tr>
        <td>{message.system}</td>
        <td>{message.dateTimeStamp}</td>
        <td>{message.message}</td>
    </tr>
)

export default MessageInstance;