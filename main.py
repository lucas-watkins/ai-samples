from ultralytics import YOLO
from PIL import Image
import cv2



vid = cv2.VideoCapture(int(input("OpenCV Webcam Number: ")))
model = YOLO("yolov8n.pt") 



while True:
    
    results = model.predict(source=vid.read()[1], stream=False, verbose = False, conf = 0.5)

    for result in results:
        #show image with boxes
        im_array = result.plot()  # plot a BGR numpy array of predictions
        im = Image.fromarray(im_array[..., ::-1])  # RGB PIL image
        cv2.imshow('Frame', cv2.cvtColor(im_array, cv2.COLOR_RGBA2RGB))

        # gets names of objects detected in frame
        names = []
        for index in range(result.boxes.shape[0]):
            cls = int(result.boxes.cls[index].item())
            names.append(result.names[cls])
        
        print(names)
    
    
    # quit if q is pressed
    if cv2.waitKey(1) & 0xFF == ord('q'): 
        break




