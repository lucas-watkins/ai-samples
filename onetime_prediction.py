from ultralytics import YOLO
from sys import argv

model = YOLO('yolov8n')

result = model.predict(argv[1], verbose = False, conf = 0.5)[0]

detected_objects = list()

for index, item in enumerate(result):
    cls = int(result.boxes.cls[index].item())
    detected_objects.append(result.names[cls])

for object in detected_objects: print(object)